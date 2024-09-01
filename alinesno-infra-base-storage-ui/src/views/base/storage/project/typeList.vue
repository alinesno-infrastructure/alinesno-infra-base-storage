<template>
   <div>
      <el-row :gutter="20">
         <!--应用数据-->
         <el-col :span="24" :xs="24">
            <!-- <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="100px">
               <el-form-item label="应用名称" prop="typeName">
                  <el-input v-model="queryParams.typeName" placeholder="请输入应用名称" clearable style="width: 240px" @keyup.enter="handleQuery" />
               </el-form-item>
               <el-form-item>
                  <el-button type="primary" icon="Search" @click="handleQuery">搜索</el-button>
                  <el-button icon="Refresh" @click="resetQuery">重置</el-button>
               </el-form-item>
            </el-form> -->

            <el-table ref="multipleTableRef" v-loading="loading" :data="typeList" @selection-change="handleSelectionChange">
               <el-table-column type="index" 序号 width="50" align="center" />
               <el-table-column label="图标" align="center" width="70" key="icon" v-if="columns[5].visible">
                  <template #default="scope">
                     <span style="font-size:25px;color:#3b5998">
                        <i :class="scope.row.icon" />
                     </span>
                  </template>
               </el-table-column>

               <!-- 业务字段-->
               <el-table-column label="类型名称" align="center" width="150" key="typeName" prop="typeName" v-if="columns[0].visible" />
               <el-table-column label="类型描述" align="left" key="typeDesc" prop="typeDesc" v-if="columns[0].visible" />
               <el-table-column  label="选择" type="selection" width="50" align="center" />
            </el-table>
            <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
         </el-col>
      </el-row>

   </div>
</template>

<script setup name="Type">

const props = defineProps({
   selectedRowKeys: {
      type: String ,
   }
})

import {
   listType,
   delType,
   getType,
   updateType,
   addType ,
   changStatusField
} from "@/api/base/storage/type";

const router = useRouter();
const { proxy } = getCurrentInstance();

// 定义变量
const typeList = ref([]);
const open = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref([]);
const types = ref([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const title = ref("");
const dateRange = ref([]);
const postOptions = ref([]);
const roleOptions = ref([]);

// 判断是否在点击弹窗确认按钮时才调用接口
const multipleTableRef = ref(null)

// 列显隐信息
const columns = ref([
   { key: 0, label: `应用名称`, visible: true },
   { key: 1, label: `应用描述`, visible: true },
   { key: 2, label: `表数据量`, visible: true },
   { key: 3, label: `类型`, visible: true },
   { key: 4, label: `应用地址`, visible: true },
   { key: 5, label: `状态`, visible: true },
   { key: 6, label: `更新时间`, visible: true }
]);

const data = reactive({
   form: {},
   queryParams: {
      pageNum: 1,
      pageSize: 10,
      typeName: undefined,
      isOpen: undefined
   },
   rules: {
      typeName: [{ required: true, message: "名称不能为空", trigger: "blur" }] ,
      jdbcUrl: [{ required: true, message: "连接不能为空", trigger: "blur" }],
      isRateLimited: [{ required: true, message: "类型不能为空", trigger: "blur" }] ,
      dbUsername: [{ required: true , message: "用户名不能为空", trigger: "blur"}],
      dbPasswd: [{ required: true, message: "密码不能为空", trigger: "blur" }] ,
      isOpen: [{ required: true, message: "备注不能为空", trigger: "blur" }]
   }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询应用列表 */
function getList() {
   loading.value = true;
   listType(proxy.addDateRange(queryParams.value, dateRange.value)).then(res => {
      loading.value = false;
      typeList.value = res.rows;
      total.value = res.total;

      nextTick(() => {
         handleSetRow(props.selectedRowKeys)
      });
   });
};

/** 搜索按钮操作 */
function handleQuery() {
   queryParams.value.pageNum = 1;
   getList();
};

/** 重置按钮操作 */
function resetQuery() {
   dateRange.value = [];
   proxy.resetForm("queryRef");
   queryParams.value.deptId = undefined;
   proxy.$refs.deptTreeRef.setCurrentKey(null);
   handleQuery();
};
/** 删除按钮操作 */
function handleSelectRow() {
   return ids.value;
};

/** 选择条数  */
function handleSelectionChange(selection) {
   ids.value = selection.map(item => item.id);
   types.value = selection.map(item => item.typeName);
   single.value = selection.length != 1;
   multiple.value = !selection.length;
};

/** 重置操作表单 */
function reset() {
   form.value = {
      id: undefined,
      deptId: undefined,
      TypeName: undefined,
      requestCount: undefined,
      password: undefined,
      phonenumber: undefined,
      status: "0",
      remark: undefined,
   };
   proxy.resetForm("databaseRef");
};
/** 取消按钮 */
function cancel() {
   open.value = false;
   reset();
};

/** 新增按钮操作 */
function handleAdd() {
   reset();
   open.value = true;
   title.value = "添加应用";
};

/** 传递进入的数组默认选中 */
function handleSetRow() {

  console.log('rows = ' + props.selectedRowKeys)
  // 解析传入的字符串化数组
  let json = props.selectedRowKeys.replace(/:s*([0-9]{15,})s*(,?)/g, ': "$1" $2') ;
  let documentTypeArr = JSON.parse(json);

  // 遍历表格中的每一行
  typeList.value.forEach(row => {
    // 如果表格实例存在
    if (multipleTableRef.value) {
      console.log('row.id = ' + row.id + ' , documentTypeArr = ' + documentTypeArr)
      // 判断 row.id 是否在 documentTypeArr 中
      if (documentTypeArr.includes(row.id)) {
        // 如果存在，则选中该行
        multipleTableRef.value.toggleRowSelection(row, true);
      }
    }
  });
}

const handleChangStatusField = async(field , value , id) => {
    // 判断tags值 这样就不会进页面时调用了
      const res = await changStatusField({
         field: field,
         value: value?1:0,
         id: id
      }).catch(() => { })
      if (res && res.code == 200) {
         // 刷新表格
         getList()
      }
}

getList();

// 向父类暴露方法
defineExpose({ handleSetRow , handleSelectRow });

</script>
