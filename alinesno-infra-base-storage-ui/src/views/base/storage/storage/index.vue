<template>
  <div class="app-container">
    <el-container class="el-container">
        <AsideMenu></AsideMenu>
        <el-main class="el-main">
          <router-view></router-view>
        </el-main>
    </el-container>
  </div>
</template>

<script setup>
import AsideMenu from '@/views/base/storage/storage/AsideMenu.vue'

</script>

<style scoped>

.file-wrapper {
  width: 100% !important;
}


.el-main {
  padding: 0px 16px !important;
  overflow: hidden;
}
</style>
