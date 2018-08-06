<template>
  <div class="login-container">
    <el-form autoComplete="on" :model="loginForm" :rules="loginRules" ref="loginForm" label-position="left" label-width="0px"
             class="card-box login-form">
      <h3 class="title">Shopping Mall</h3>
      <el-form-item>
        <video id="video"></video>
        <canvas id="canvas" width="640" height="480"></canvas>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" style="width:100%;" :loading="loading" @click.native.prevent="photo">
          登 录
        </el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>

  export default {
    name: 'VideoLogin',
    data() {
      return {

      };
    },

    created() {
      !(function () {
        function userMedia() {
          return navigator.getUserMedia = navigator.getUserMedia ||
            navigator.webkitGetUserMedia ||
            navigator.mozGetUserMedia ||
            navigator.msGetUserMedia || null;
        }
        if (userMedia()) {
          const constraints = {
            video: true,
            audio: false
          };
          const media = navigator.getUserMedia(constraints, function (stream) {
            const v = document.getElementById('video');
            const url = window.URL || window.webkitURL;
            v.src = url ? url.createObjectURL(stream) : stream;
            v.play();
          }, function (error) {
            console.log("ERROR");
            console.log(error);
          });
        } else {
          console.log("不支持");
        }
      })();
    },

    methods: {
      photo() {
        const context = canvas.getContext("2d");
        const video = document.getElementById("video");
        context.drawImage(video,0,0,640,480);
      }
    }
  };
</script>
