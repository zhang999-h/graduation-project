<template>
  <div
    style="
      height: 50px;
      line-height: 50px;
      border-bottom: 1px solid #ccc;
      display: flex;
    "
  >
    <div style="width: 200px">后台管理</div>
    <div style="flex: 1"></div>
    <div style="width: 150px">
      <div class="flex flex-wrap items-center">
        <el-dropdown split-button type="primary" @click="handleClick">
          {{ userInfo.username }}

          <template #dropdown>
            <el-dropdown-menu>
              <el-dropdown-item @click="dialogVisible2=true">修改密码</el-dropdown-item>
              <el-dropdown-item @click="dialogVisible=true">登出</el-dropdown-item>

            </el-dropdown-menu>
          </template>
        </el-dropdown>
      </div>
    </div>
  </div>
  <!--  changPWD-->
  <el-dialog
      v-model="dialogVisible2"
      title="修改密码"
      width="30%"
      :before-close="handleClose"
  >
    <el-form :model="user" label-width="120px">
      <el-form-item label="账号">
        <span>{{userInfo.num}}</span>
      </el-form-item>
      <el-form-item label="原密码">
        <el-input v-model="user.password" style="width: 80%"></el-input>
      </el-form-item>
      <el-form-item label="新密码">
        <el-input v-model="user.newPassword" style="width: 80%"></el-input>
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible2 = false">取消</el-button>
        <el-button type="primary" @click="changePWD">
          修改
        </el-button
        >
      </span>
    </template>
  </el-dialog>
  <el-dialog
      v-model="dialogVisible"
      title="Tips"
      width="30%"
      :before-close="handleClose"
  >
    <span>确认退出登录吗？</span>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="logout()"
        >确认</el-button
        >
      </span>
    </template>
  </el-dialog>
</template>

<script>
export default {
  name: "Header",
  created() {
    if(!sessionStorage.getItem("manager")){
      this.$router.push("/login")
    }

  },
  mounted() {
    this.userInfo=JSON.parse(sessionStorage.getItem("manager"));
  },
  data(){
    return {
      user:{},
      dialogVisible2:false,
      dialogVisible:false,
      userInfo:{}
    }
  },
  methods : {

      logout(){
        this.dialogVisible=true
        this.$message({
          type:"success",
          message:"退出成功"
        })
        sessionStorage.removeItem("manager");
        this.$router.push("/login")
      },
    changePWD(){
      request.get("/teacher/changePWD",{
        params:{
          id:this.userInfo.id,
          password:this.userInfo.password,
          newPassword:this.user.newPassword,
        }
      }).then(res=>{
        this.dialogVisible2=false
        this.$message({
          type:"success",
          message:"修改成功"
        })
      })
    }
  },

};
import { ArrowDown } from "@element-plus/icons-vue";

const handleClick = () => {
  // eslint-disable-next-line no-alert
  alert("button click");
};
</script>

<style scoped>
.example-showcase .el-dropdown + .el-dropdown {
  margin-left: 15px;
}
.example-showcase .el-dropdown-link {
  cursor: pointer;
  color: var(--el-color-primary);
  display: flex;
  align-items: center;
}
</style>