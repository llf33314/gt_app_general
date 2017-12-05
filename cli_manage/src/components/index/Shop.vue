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
      <div class="content-row" v-if="!loading" @click="jumpPages">
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
      <div class="content-row" v-if="!loading">
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
  </div>
</template>
<script>
import { index } from "./../../assets/js/api.js";
import computed from "./../../assets/js/computed.js";
export default {
  data() {
    return {
      data: {},
      loading: true
    };
  },
  store: this.$store,
  computed: this.$computed,
  methods: {
    jumpPages() {
      let count = parseInt(this.clickCount);
      if (isNaN(count)) {
        count = 0;
      }
      count++;
      this.$store.commit("clickCount", count);
      let msg = "现在还没地方跳转啊，不过你既然点了，还是要给点反应 0.0";
      if (parseInt(this.clickCount) >= 5 && parseInt(this.clickCount) < 20) {
        msg = "不要再点我啦 - -#";
      } else if (parseInt(this.clickCount) >= 20 && parseInt(this.clickCount) < 22) {
        msg = "好吧，你点吧，我帮你计数";
      } else if (parseInt(this.clickCount) > 21 && parseInt(this.clickCount) < 999) {
        msg = "你已经点了我 " + this.clickCount + " 下";
      } else if (parseInt(this.clickCount) > 999) {
        msg = "厉害了！我的哥！你点 " + this.clickCount + " 下！";
      }
      if (window.tmp !== "") {
        window.tmp.close();
      }
      window.tmp = this.$toast({
        message: msg,
        position: "middle",
        duration: 5000
      });
      // this.$router.push({
      //   path: "/indexPage"
      // });
    }
  },
  mounted() {
    const vm = this;
    //根据行业code获取各行业信息
    index.getIndustryInfo({
      params: 11,
      fn: data => {
        vm.data = data;
        vm.loading = false;
      }
    });
  }
};
</script>