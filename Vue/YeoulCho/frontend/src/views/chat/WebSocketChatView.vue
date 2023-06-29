<template>
    <div>
      <h2>Vue로 만든 WebSocket 예제</h2>
      <p v-if="connected">WebSocket 연결 성공!</p>
      <p v-else>WebSocket 연결 실패!</p>
    </div>
  </template>

  <script>
  // npm install vue-socket.io --save-dev
  import io from 'socket.io-client';
  
  export default {
    data() {
      return {
        connected: false,
        socket: null
      };
    },
    mounted() {
      this.socket = io('http://localhost:9999', {
        reconnection: false,
        //연결이 끊어져도 다시 연결하지 않겠다.
        query: `username='hi'&room='test'`,
        // http로 보낸다. 쿼리파라미터에 username은 hi room은 test 
      })
  
      this.socket.on('connect', () => {
        this.connected = true
      });
      //연결
  
      // this.socket.on('message', (message) => {
      //   this.messages.push(message);
      // });
  
      this.socket.on('disconnect', () => {
        this.connected = false
     //끊겠다.
      });
      this.$once('hook:beforeDestroy', () => {
        this.socket.disconnect()
      })
      // 페이지가 다른거로 바뀌기전에 끊겠다.
    },
    methods: {
      // sendMessage() {
      //   if (this.socket.connected) {
      //     this.socket.emit('message', this.inputText);
      //     this.inputText = '';
      //   }
      // }
    }
  };
  </script>