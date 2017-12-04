<template>
    <div class="index">
        <div class="index-user">
          <div class="index-user-row">
            <span class="flex-1 text-xs">好汤姆</span>
            <span class="flex-1 text-right text-xs">剩余 <b class="text-md">999</b> 天</span>            
          </div>
          <div class="index-user-row">
            <span class="flex-1">
              <span class="index-user-iden">
                <svg class="icon" aria-hidden="true">
                  <use xlink:href="#icon-zhizunban"></use>
                </svg>
                <span class="text text-xs">至尊版</span>
              </span>
            </span>
            <span class="flex-1 text-right text-xs">2017-12-01</span>            
          </div>
        </div>
        <div class="index-total">
          <span class="flex-1">
            <div class="index-total-number">988.18</div>
            <div class="index-total-text">粉币</div>
          </span>
          <span class="flex-1">
            <div class="index-total-number">99</div>
            <div class="index-total-text">剩余短信</div>
          </span>
          <span class="flex-1">
            <div class="index-total-number">123456</div>
            <div class="index-total-text">流量包</div>
          </span>
        </div>
        <!--车小算-->
        <div class="index-info">
          <div class="index-info-title">
            <svg class="icon" aria-hidden="true">
              <use xlink:href="#icon-car"></use>
            </svg>
            <span>车小算</span>
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
    padding: 0 20px;
    background: -moz-linear-gradient(
      right top,
      left bottom,
      #ff8261 0%,
      #ff4257 100%
    );
    background: -webkit-gradient(
      linear,
      right top,
      color-stop(0%, #ff8261),
      color-stop(100%, #ff4257)
    );
    background: -webkit-linear-gradient(right top, #ff8261 0%, #ff4257 100%);
    background: -o-linear-gradient(right top, #ff8261 0%, #ff4257 100%);
    background: -ms-linear-gradient(right top, #ff8261 0%, #ff4257 100%);
    background: linear-gradient(to right top, #ff8261 0%, #ff4257 100%);
    .index-user-row {
      display: flex;
      padding: 7px 0;
      align-items: center;
      .index-user-iden {
        height: 66px/@p;
        border-radius: 66px/@p;
        padding: 0 10px 0 2px;
        background-color: #ff9d90;
        .icon {
          font-size: 20px;
          padding-top: 1px;
          vertical-align: middle;
        }
        .text {
          line-height: 66px/@p;
          word-wrap: normal;
          text-overflow: ellipsis;
          overflow: hidden;
          vertical-align: middle;
        }
      }
      .text-md {
        font-weight: 549;
      }
    }
  }
  .index-total {
    width: 100%;
    border-bottom: 10px solid @brGray;
    display: flex;
    .flex-1 {
      text-align: center;
      .index-total-number {
        color: @red;
        font-size: 60px/@p;
        padding-top: 15px;
      }
      .index-total-text {
        padding-top: 15px;
        padding-bottom: 20px;
        color: @gray;
        font-size: 40px/@p;
      }
    }
  }
  .index-info {
    .index-info-title {
      height: 120px/@p;
      line-height: 120px/@p;
      font-size: 45px/@p;
      text-align: center;
      border-bottom: 1px solid @brGray;
      .icon {
        border-radius: 100%;
        color: #fff;
        font-size: 20px;
        background: -moz-linear-gradient(left, right, #23c0f6 0%, #229beb 100%);
        background: -webkit-gradient(
          linear,
          right,
          color-stop(0%, #23c0f6),
          color-stop(100%, #229beb)
        );
        background: -webkit-linear-gradient(right, #23c0f6 0%, #229beb 100%);
        background: -o-linear-gradient(right, #23c0f6 0%, #229beb 100%);
        background: -ms-linear-gradient(right, #23c0f6 0%, #229beb 100%);
        background: linear-gradient(to right, #23c0f6 0%, #229beb 100%);
      }
    }
  }
}
</style>
