new Vue({
    el:"#app",
    data() {
        var validatePass = (rule, value, callback) => {
            if (value === "") {
                callback(new Error("请输入用户信息"));
            } else {
                if (this.ruleForm.checkPass !== "") {
                    this.$refs.ruleForm.validateField("checkPass");
                }
                callback();
            }
        };
        var validatePass2 = (rule, value, callback) => {
            if (value === "") {
                callback(new Error("请输入密码"));
            } else if (value.length < 8 || value.length > 13) {
                callback(new Error("长度必须在8-12之内!"));
            } else {
                callback();
            }
        };
        return {
            loading: false,
            ruleForm: {
                pass: "",
                checkPass: "",
            },
            rules: {
                pass: [{ validator: validatePass, trigger: "blur" }],
                checkPass: [{ validator: validatePass2, trigger: "blur" }],
            },
            isLogin:true,
            userData:{
                username:'',
                password:''
            },
            url:{
                login:'http://localhost:8080/SSM_war_exploded/user/login',
                register:'http://localhost:8080/SSM_war_exploded/user/register'
            }
        };
    },
    created() {
    },
    methods:{
        login() {
            this.loading=true;
            axios({
                method: 'post',
                url: this.url.login,
                data: JSON.stringify(this.userData),
                headers: {
                    'Content-Type': 'application/json;charset=UTF-8'
                }
            }).then(res=>{
                if(res.data["sign"]) {
                    this.$message({
                        message:res.data["msg"],
                        type:'success',
                        showClose:true,
                        duration:0
                    });
                    setTimeout(() => {
                        this.loading = false;
                    }, 2000);
                    window.location.href=res.data["url"];
                } else {
                    this.loading=false;
                    this.$message.error({
                        message:res.data["msg"],
                        showClose: true,
                        duration: 0
                    });
                }
            }).catch(err=>{
                console.log(err);
            })
        },
        register() {
            axios({
                method: 'post',
                url: this.url.register,
                data: JSON.stringify(this.userData),
                headers: {
                    'Content-Type': 'application/json;charset=UTF-8'
                }
            }).then(res=>{
                console.log(res.data);
                alert(res.data["msg"]);
                if(res.data["res"]===1) this.login();
                else {
                    this.userData.username='';
                    this.userData.password='';
                }
            }).catch(err=>{
                console.log(err);
            })
        }
    }
})