<template lang="">
    <div>
        <h2>Vue로 만든 WebSocket 예제</h2>
        <p v-if="connected">WebSocket 연결 성공</p>
        <p v-if="!connected">WebSocket 연결 실패!</p>
    </div>
</template>

<script>
import io from 'socket.io-client'
export default {
    data() {
        return {
            connected: false,
            socket: null,
        }
    },
    mounted() {
        this.socket = io("http://localhost:9999", {
            reconnection: false,
            query: `username="hi"&room="test"`,
        })

        this.socket.on('connect', () => {
            this.connected = true
        })

        this.socket.on('disconnect', () => {
            this.connected = false
        })

        this.$once('hook:beforeDestroy', () => {
            this.socket.disconnect()
        })
    }
}
</script>

<style lang="">
    
</style>