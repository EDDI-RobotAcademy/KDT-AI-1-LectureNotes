const EventBus = {
    // 이벤트를 저장할 객체
    events: {},

    // 이벤트 등록 메서드
    on(event, callback) {
        console.log('event-bus on - event' + event + ', callback - ' + callback)
        if (!this.events[event]) {
            this.events[event] = [];
        }
        this.events[event].push(callback);
    },

    // 이벤트 발생 메서드
    emit(event, data) {
        console.log('event-bus emit: ' + event + ', data: ' + data)
        if (this.events[event]) {
            this.events[event].forEach(callback => {
                callback(data);
                console.log('callback 실행: ' + data)
            });
        }
    }
};

export default EventBus;
