<template>
  <div style="margin:10px">
    <el-button @click="add" type="primary">新增教师</el-button>
    <el-upload action="http://localhost:8081/import/teacher" :show-file-list="false" :on-success="handleExcelImportSuccess" style="display: inline-block">
      <el-button   style="margin: 20px" type="primary" class="ml-5">导入 <i class="el-icon-bottom"></i></el-button>
    </el-upload>
<!--    <el-button>导入</el-button>-->
    <el-button @click="exp" style="margin: 10px" type="primary">导出</el-button>
  </div>
  <div style="margin:10px">
    <el-input v-model="searchName" placeholder="查询教师姓名" style="width: 20% "/>
    <el-input v-model="searchNum" placeholder="查询教师工号" style="width: 20%;margin: 10px"/>
    <el-button @click="load" style="margin:10px">查询</el-button>
  </div>
  <el-table :data="Users" stripe style="width: 60%">
    <el-table-column type="selection" width="55"/>
    <el-table-column prop="num" label="工号" width="180"/>
    <el-table-column prop="username" label="姓名" width="180"/>
    <el-table-column prop="password" label="密码"/>
    <el-table-column fixed="right" label="Operations" width="180">
      <template  #default="scope">
        <el-button type="text" @click="handleEdit(scope.row)">
          编辑
        </el-button>
        <el-popconfirm title="确认删除吗?" @confirm="handleDel(scope.row.id)">
          <template #reference>
            <el-button type="text">删除</el-button>
          </template>
        </el-popconfirm>
      </template>
    </el-table-column>
  </el-table>
  <div class="demo-pagination-block" style="margin: 10px 0">
    <div class="demonstration"></div>
    <el-pagination
        v-model:currentPage="currentPage"
        v-model:page-size="pageSize"
        :page-sizes="[5, 10, 15]"
        :small="small"
        :disabled="disabled"
        :background="background"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
    />
  </div>
  <!--  新增人员的弹出框-->
  <el-dialog
      v-model="dialogVisible"
      title="Tips"
      width="30%"
      :before-close="handleClose"
  >
    <el-form :model="user" label-width="120px">
      <el-form-item label="工号">
        <el-input v-model="user.num" style="width: 80%"></el-input>
      </el-form-item>
      <el-form-item label="姓名">
        <el-input v-model="user.username" style="width: 80%"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="user.password" style="width: 80%"></el-input>
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="save">
          增加
        </el-button
        >
      </span>
    </template>
  </el-dialog>
</template>

<script>
import request from "@/utils/requset";

export default {
  name: "TeacherView",
  data() {
    return {
      searchName:'',
      searchNum:'',
      user: {
        // id:1,
        //  num:'',
        //  username:'',
        //  password:'',
      },
      dialogVisible: false,
      currentPage: 1,
      total: 10,
      pageSize: 10,
      pageNum:1,
      Users: [

      ]
    }
  },
  created() {
    this.load()
  },
  methods: {
    load(){
      request.get("/searchTeacher",{
        params:{
          pageNum:this.currentPage,
          pageSize:this.pageSize,
          searchName:this.searchName,
          searchNum:this.searchNum
        }
      }).then(res=>{
        this.Users=res.data.records
        this.total=res.data.total
      })
    },
    handleDel(id){
      console.log(id)
        request.delete("/delTeacher/"+id)
            .then(res=>{
              if(res.code==='0'){
                this.$message({
                  type:"success",
                  message:"删除成功"
                })
              }
              else{
                this.$message({
                  type:"error",
                  message:res.msg
                })
              }
              this.load()
        })
    },
    handleEdit(row) {

      this.user=JSON.parse(JSON.stringify(row))
      this.dialogVisible=true
    },
    handleSizeChange() {
      this.load()
    },
    handleCurrentChange() {
      this.load()
    },
    add() {
      this.dialogVisible = true;
      this.user={};
    },
    save(){
      if(this.user.id){//update
        request.put("/updateTeacher",this.user).then(res=>{
          console.log(res);
          if(res.code=='0'){
            this.$message({
              type:"success",
              message:"更新成功"
            })
          }
          else{
            this.$message({
              type:"error",
              message:res.msg
            })
          }
        })
      }
      else{
        request.post("/addTeacher",this.user).then(res=>{

          if(res.code=='0'){
            this.$message({
              type:"success",
              message:"增加成功"
            })
          }
          else{
            this.$message({
              type:"error",
              message:res.msg
            })
          }
        })
      }
      this.load()
      this.dialogVisible=false
    },
    exp() {
      window.open("http://localhost:8081/export/teacher")
    },
    handleExcelImportSuccess() {
      this.$message.success("导入成功")
      this.load()
    }
  }
}
</script>

<style scoped>

</style>