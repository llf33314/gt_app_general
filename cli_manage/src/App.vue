<template>
  <div id="app">
    <keep-alive>
      <router-view class="router-view" v-if="$route.meta.keepAlive" />
    </keep-alive>

    <router-view class="router-view" v-if="!$route.meta.keepAlive" />
  </div>
</template>