package com.holanswide.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSON;
import com.holanswide.mapper.FileMapImp;
import com.holanswide.model.FileInfo;
import com.holanswide.utils.SpringBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.UUID;

/**
 * @author ：holan
 * @description：TODO
 * @date ：2022/8/12
 */
@Controller
@RequestMapping(value = "/file")
public class FileController {
    @GetMapping(value = "/all",produces = {"application/json;charset=UTF-8"})
    public @ResponseBody
    String getAllInfo() {
        return JSON.toJSONString(
                SpringBean.getAc().getBean("fileMapImp", FileMapImp.class).queryFileInfoAll()
        );
    }
    @PostMapping("/del")
    public @ResponseBody
    String delInfo(@RequestBody String obj) {
        String url=JSON.parseObject(obj).getString("url");
        SpringBean.getAc().getBean("fileMapImp", FileMapImp.class).delFileByURL(url);
        return "1";
    }
    @GetMapping(value = "/myfile",produces = {"application/json;charset=UTF-8"})
    public @ResponseBody
    String getMyInfo(@RequestParam(name = "uid",required = true) int uid) {
        return JSON.toJSONString(
                SpringBean.getAc().getBean("fileMapImp", FileMapImp.class).queryFileInfoByUid(uid)
        );
    }
    //    单个文件直接上传
    @PostMapping(value = "/upload", produces = {"multipart/form-data"})
    public @ResponseBody
    String uploadFile(@RequestParam(value = "files") MultipartFile file, HttpServletRequest request) throws Exception {
        String fileName = file.getOriginalFilename();

        System.out.println(">filename:" + fileName);
//         检测是否为空
        if ("".equals(fileName)) {
            return JSON.toJSONString(new UploadSendBody(0, "未上传文件到服务器"));
        }
//        文件重命名
        fileName = UUID.randomUUID().toString() + "." + fileName.split("\\.")[1];
        System.out.println("realName:" + fileName);
//        保存路径
        String path = request.getSession().getServletContext().getRealPath("/upload");
        System.out.println(">Path:" + path);
        File realPath = new File(path);
        if (!realPath.exists()) realPath.mkdir();

        InputStream is = file.getInputStream(); //文件输入流
        assert fileName != null;
        OutputStream os = Files.newOutputStream(new File(realPath, fileName).toPath()); //文件输出流

        //读取写出
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
            os.flush();
        }
        os.close();
        is.close();

        String url = "http://localhost/upload/";
        url+=fileName;
        return url;
    }
    //    文件信息添加进数据库
    @PostMapping(value = "/details",produces = {"application/json;charset=UTF-8"})
    public @ResponseBody
    String uploadDetails(@RequestBody String obj, HttpServletRequest request) {
        FileInfo fileInfo = JSON.parseObject(obj).getObject("fileInfo", FileInfo.class);
        System.out.println(fileInfo);
        if( SpringBean.getAc().getBean("fileMapImp", FileMapImp.class).addFile(
                fileInfo
        )==1)
            return JSON.toJSONString(new UploadSendBody(1,"上传成功！"));
        else {
            return JSON.toJSONString(new UploadSendBody(0,"上传失败"));
        }
    }

}


class UploadSendBody {
    int code;
    String msg;

    public UploadSendBody(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
