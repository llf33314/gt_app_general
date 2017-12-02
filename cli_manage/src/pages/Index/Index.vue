<template>
    <div class="index">
        <div class="index-user">
          <div class="index-user-row">
            <span class="flex-1">好汤姆</span>
            <span class="flex-1 text-right">剩余<b>999</b>天</span>            
          </div>
          <div class="index-user-row">
            <span class="flex-1">aaa</span>
            <span class="flex-1 text-right">2017-12-01</span>            
          </div>
        </div>
    </div>
</template>
<script>
import { index } from "@/assets/js/api.js";
import store from "@/assets/js/store.js";
import { mapState, mapMutations, mapGetters } from "vuex";

export default {
  data() {
    return {
      user: ""
    };
  },
  methods: {
    jumpPages() {
      this.$router.push({
        path: "/indexPage"
      });
    }
  },
  computed: mapState({
    userId: function(state) {
      let localData = window.localStorage.getItem("userId");
      if (state.user_id === 0 && localData) {
        this.$store.commit("userId", localData);
      }
      return state.userId;
    }
  }),
  mounted() {
    const vm = this;
  },
  store
};
</script>
<style lang="less" scoped>
.index {
  width: 100%;
  .index-user {
    width: 100%;
    height: 208px/@p;
    color: @white;
    padding: 0 10px;
    background: -moz-linear-gradient(right top, left bottom, #ff8261 0%, #ff4257 100%);
    background: -webkit-gradient(linear, right top, color-stop(0%,#ff8261), color-stop(100%,#ff4257));
    background: -webkit-linear-gradient(right top, #ff8261 0%,#ff4257 100%);
    background: -o-linear-gradient(right top, #ff8261 0%,#ff4257 100%);
    background: -ms-linear-gradient(right top, #ff8261 0%,#ff4257 100%);
    background: linear-gradient(to right top, #ff8261 0%,#ff4257 100%);
    .index-user-row {
      display: flex;
      padding: 10px 0;
    }
  }
}
</style>
