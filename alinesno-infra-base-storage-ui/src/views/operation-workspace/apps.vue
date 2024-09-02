<template>
  <div>
    <el-row class="acp-dashboard-panel" :gutter="20">
      <el-col class="panel-col" :span="19">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title"><i class="fa-solid fa-link"></i> 服务特点</div>
          </div>
          <div class="panel-body" style="height: auto;position: relative;">
              <div class="direct-box">
                <ul>
                  <li class="box-item" v-for="item in storageFeatures" :key="item">
                    <div class="dire-panel">
                      <div class="panel-title">
                        <i class="dire-panel-icon" :class="item.icon" :alt="item.name" />
                        {{ item.name }} 
                      </div>
                      <div class="panel-describe">
                        {{ item.desc }}
                      </div>
                      <!-- <div class="panel-tip">访问链接</div> -->
                    </div>
                  </li>
                </ul>
              </div>
          </div>
        </div>
      </el-col>
      <el-col :span="5">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title"><i class="fa-solid fa-link"></i> 应用场景</div>
          </div>
          <div class="panel-body" style="height: auto;position: relative;">
            <div class="acp-app-list">
              <ul>
                <li class="app-items" style="width:100%" v-for="item in useScenarios" :key="item">
                  <div class="app-info">
                    <div class="app-item-title">
                        <i :class="item.icon" :alt="item.name" />
                        {{ item.name }} 
                    </div>
                    <div class="app-item desc">{{ item.desc }}</div>
                  </div>
                </li>
              </ul>
            </div>
          </div>

        </div>
      </el-col>
    </el-row>

  </div>
</template>

<script setup>

const storageFeatures = ref([
  { icon: 'fa-solid fa-server', name: '高可扩展性', desc: '能够轻松地通过添加更多的节点来扩展存储容量和处理能力，支持PB级的数据量' },
  { icon: 'fa-solid fa-shield-halved', name: '数据持久性', desc: '采用多副本或纠删码机制来保证数据的持久性和可靠性，即使多个节点发生故障也不丢失数据' },
  { icon: 'fa-solid fa-network-wired', name: '高性能', desc: '利用快速的网络协议和优化的数据访问模式，提供低延迟和高吞吐量的数据存取性能' },
  { icon: 'fa-solid fa-eye', name: '在线预览', desc: '无需下载即可直接浏览文档、图片和其他文件类型，提升用户体验和效率' },
  { icon: 'fa-solid fa-lock', name: '安全性', desc: '内置安全特性，包括身份验证、访问控制以及数据传输加密，确保数据的安全性和隐私保护' },
]);

const useScenarios = ref([
  { icon: 'fa-solid fa-database', name: '大数据分析平台', desc: '作为大数据分析系统的底层存储，支持海量非结构化数据的长期保存与分析' },
  { icon: 'fa-solid fa-cloud-upload-alt', name: '云备份解决方案', desc: '提供可靠的数据备份服务，确保重要数据不会因硬件故障而丢失' },
  { icon: 'fa-solid fa-image', name: '媒体资产管理', desc: '为媒体公司提供图片、视频等内容的高效存储与快速访问服务' },
  { icon: 'fa-solid fa-chart-column', name: '数据湖构建', desc: '构建数据湖的基础架构，支撑各种数据处理和分析任务' },
]);

</script>