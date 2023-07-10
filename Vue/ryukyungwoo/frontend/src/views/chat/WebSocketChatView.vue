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
        query: `username='hi'&room='test'`,
      })
  
      this.socket.on('connect', () => {
        this.connected = true
      });
  
      // this.socket.on('message', (message) => {
      //   this.messages.push(message);
      // });
  
      this.socket.on('disconnect', () => {
        this.connected = false
      });
      this.$once('hook:beforeDestroy', () => {
        this.socket.disconnect()
      })
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