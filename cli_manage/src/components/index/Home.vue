<template>
  <div class="index-info homeModule">
    <div class="index-info-title">
        <span class="icon-bg">
            <svg class="icon" aria-hidden="true">
                <use xlink:href="#icon-wuye"></use>
            </svg>
        </span>
        <span>揽胜家园</span>
    </div>
    <div class="index-info-content">
      <mt-spinner color="#ff4257" class="loading" v-if="loading"></mt-spinner>
      <div class="content-row" v-if="!loading" @click="jumpPages">
        <div class="content-col">
            <div class="col-number">{{data.monthReceivable.toFixed(3)}}</div>
            <div class="col-text">本月应收</div>
        </div>
        <div class="content-col">
            <div class="col-number">{{data.monthReceipts.toFixed(3)}}</div>
            <div class="col-text">本月实收</div>
        </div>
        <div class="content-col">
            <div class="col-number">{{data.monthNewCheck}}</div>
            <div class="col-text">本月新入住</div>
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
      } else if (parseInt(this.clickCount) > 21 && parseInt(this.clickCount) <= 999) {
        msg = "你已经点了我 " + this.clickCount + " 下";
      } else if (parseInt(this.clickCount) > 999 && parseInt(this.clickCount) <= 9999) {
        msg = "厉害了！我的哥！你点 " + this.clickCount + " 下！";
      } else if (parseInt(this.clickCount) > 9999) {
        msg = "逆天了！你突破 " + this.clickCount + " 下！我喝口水，接着数。";
      }
      if (window.tmp !== "") {
        window.tmp.close();
      }
      window.tmp = this.$toast({
        message: msg,
        position: "middle",
        duration: 5000
      });
    }
  },
  store: this.$store,
  computed,
  mounted() {
    const vm = this;
    //根据行业code获取各行业信息
    index.getIndustryInfo({
      params: 5,
      fn: data => {
        vm.data = data
        vm.loading = false
      }
    });
  }
};
</script>