<template>
  <el-form
      :model="Draft" label-width="120px">
    <el-form-item label="题目" prop="title">
      <el-input v-model="Draft.title"/>
    </el-form-item>
    <el-form-item label="正文" prop="content">
      <v-md-editor v-model="Draft.content"></v-md-editor>
    </el-form-item>
<!--    <el-form-item>-->
<!--      <input type="file" @change="getFile($event)">-->
<!--    </el-form-item>-->

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
        发布
      </el-button>
      <el-button @click="resetForm(ruleFormRef)">
        Reset
      </el-button>
    </el-form-item>

  </el-form>

</template>

<script>
import request from "@/utils/requset";

export default {
  name: "DraftView",
  data() {
    return {
      Draft: {
        title: '',
        content: '',
        file: '',

      },
    }
  },
  methods: {
    fileUpload(res){

      this.Draft.fileUrl=res.data
    },
    add() {
      request.post("/addNotice", this.Draft).then(res => {
        console.log(res);
        if (res.code == '0') {
          this.$message({
            type: "success",
            message: "发布成功"
          })
        } else {
          this.$message({
            type: "error",
            message: res.msg
          })
        }
      })
    },
  }
}
</script>


<style scoped>

</style>