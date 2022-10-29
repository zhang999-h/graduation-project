<template>
  <!--  背景-->
  <div :style="background" class="bgBackground">
  <div style="height: 100vh;width: 100% ;overflow:hidden">

    <div style="width: 400px;margin: 150px auto ;">
      <div style="font-size:30px;text-align: center;padding: 30px 0">管理员登录</div>
      <el-form ref="form" :rules="rules"
               :model="admin" size="normal" >
        <el-form-item prop="num">
          <el-input prefix-icon="Avatar" v-model.number="admin.num" >
          </el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input prefix-icon="Lock"  v-model="admin.password" show-password >
          </el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="login">登录</el-button>
        </el-form-item>
      </el-form>
    </div>


  </div>
  </div>
</template>

<script>
import request from "@/utils/requset";

export default {
  name: "LoginView",
  data() {
    return {
      background: {

        // 背景图片地址
        backgroundImage: 'url(' + require('../assets/bg2.jpg') + ')',
        // 背景图片是否重复
        backgroundRepeat: 'no-repeat',
        // 背景图片大小
        backgroundSize: 'cover',
        // 背景颜色
        backgroundColor: '#000',

        // 背景图片位置
        backgroundPosition: 'center top'
      },
      admin: {},
      rules:{
        num: [
          { required: true, message: '请输入账号', trigger: 'blur' },
          { type: 'number', message: '账号为数字值',trigger: 'change' }
         ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' }
          // { min: 3, max: 5, message: 'Length should be 3 to 5', trigger: 'blur' },
        ],
      },
    }
  },
  methods:{
    login(){
      this.$refs['form'].validate((valid) => {
        if (valid) {
          request.post("/admin/login",this.admin).then(res=>{
            console.log(res);
            if(res.code=='0'){

              this.$message({
                type:"success",
                message:"登录成功"
              })

              sessionStorage.setItem("manager",JSON.stringify(res.data))
              this.$router.push("/")
            }
            else{
              this.$message({
                type:"error",
                message:res.msg
              })
            }
          })
        }
      });

    }
  }
}
</script>

<style scoped>
.router-link-active {
  text-decoration: none;
  color: yellow;
}

a {
  text-decoration: none;
  color: white;
}

.my_table >>> .el-table__row > td {
  /* 去除表格线 */
  border: none;
}

.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}

.bgBackground{
  width:100%;
  height:100%;
  background-color:rgba(255,255,255,0.1);
}
</style>
