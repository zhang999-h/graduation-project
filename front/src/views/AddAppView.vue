<template>
  <div style="font-size: 30px;margin: 30px">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>项目申报</el-breadcrumb-item>
      <el-breadcrumb-item>提交申报</el-breadcrumb-item>
    </el-breadcrumb>
  </div>
  <el-form
      :model="Draft" label-width="120px" style="width: 800px">
    <el-form-item label="题目" prop="title">
      <el-input v-model="Draft.title"/>
    </el-form-item>
    <el-form-item label="描述" >
      <el-input
                type="textarea"
                :autosize="{ minRows: 5, maxRows: 8}"
                placeholder="请输入内容"
                v-model="Draft.description"/>
    </el-form-item>

    <el-form-item label="附件" prop="file">
      <el-upload
          action="http://localhost:8081/upload"
          multiple
          :limit="1" :on-success="fileUpload" >
        <el-button type="primary">点击上传</el-button>
        <template #tip>
          <div class="el-upload__tip">
            请上传附件
          </div>
        </template>
      </el-upload>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="add">
        提交
      </el-button>
      <el-button @click="reset">
        重置
      </el-button>
    </el-form-item>

  </el-form>
</template>

<script>
import request from "@/utils/requset";

export default {
  name: "AddAppView",
  data(){
    return{
        Draft:{},
    }
  },
  methods:{
    fileUpload(res){

      this.Draft.file=res.data
    },
    add() {
      request.post("/addApplication", this.Draft).then(res => {
        console.log(res);
        if (res.code == '0') {
          this.$message({
            type: "success",
            message: "发布成功"
          })
          this.$router.push("/application")
        } else {
          this.$message({
            type: "error",
            message: res.msg
          })
        }
      })
    },
    reset(){
      this.Draft={}
    },
  }
}
</script>

<style scoped>

</style>