<template>
  <div class="index-info shopModule">
    <div class="index-info-title">
        <span class="icon-bg">
            <svg class="icon" aria-hidden="true">
                <use xlink:href="#icon-shop"></use>
            </svg>
        </span>
        <span>商城</span>
    </div>
    <div class="index-info-content">
      <mt-spinner color="#ff4257" class="loading" v-if="loading"></mt-spinner>
      
      <!--数据展示-->
      <div v-if="!loading && !errInfo" @click="jumpInfo">
        <div class="content-row" >
            <div class="content-col">
                <div class="col-number">110</div>
                <div class="col-text">今日订单数</div>
            </div>
            <div class="content-col">
                <div class="col-number">12345</div>
                <div class="col-text">待发货</div>
            </div>
            <div class="content-col">
                <div class="col-number">3</div>
                <div class="col-text">门店自提</div>
            </div>
        </div>
        <div class="content-row">
            <div class="content-col">
                <div class="col-number">22</div>
                <div class="col-text">今日营业额</div>
            </div>
            <div class="content-col">
                <div class="col-number">123</div>
                <div class="col-text">昨日营业额</div>
            </div>
            <div class="content-col">
                <div class="col-number">1</div>
                <div class="col-text">维权订单</div>
            </div>
        </div>
      </div>

      <!--错误提示-->
      <div class="content-row" v-else-if="errInfo" @click="getData">
        <div class="content-col">
            <div class="col-text">数据获取失败，请点击重试</div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { index } from "./../../assets/js/api.js";

export default {
  data() {
    return {
      data: {},
      loading: true,
      errInfo: false
    };
  },
  methods: {
    jumpInfo() {
      if (this.data.infoUrl) {
        window.location.href = this.data.infoUrl;
      }
    },
    getData() {
      const vm = this;
      vm.loading = true;
      vm.errInfo = false;
      //根据行业code获取各行业信息
      index.getIndustryInfo({
        params: 11,
        fn: data => {
          vm.data = data;
          vm.loading = false;
        }
      });
    }
  },
  mounted() {
    this.getData();
  }
};
</script>