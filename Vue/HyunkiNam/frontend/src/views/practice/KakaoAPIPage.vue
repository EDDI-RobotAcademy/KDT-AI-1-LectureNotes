<template>
    <div>
        <h2>카카오 맵 보기</h2>
        <div id="map"></div>
    </div>
</template>

<style scoped>
#map {
    width: 100%;
    height: 400px;
}
</style>

<script>
export default {
    name: "KAKAOMAPAPI",
    data() {
        return {
            map: null,
        }
    },
    setup() { },
    created() { },
    mounted() {
        if (window.kakao && window.kakao.maps) {
            this.loadMap();
        } else {
            this.loadScript();
        }
    },
    unmounted() { },
    methods: {
        loadScript() {
            const script = document.createElement("script");
            script.src = "//dapi.kakao.com/v2/maps/sdk.js?appkey=41e3848f58cca638cbb82fb7da9bb72e&autoload=false";
            script.onload = () => window.kakao.maps.load(this.loadMap);

            document.head.appendChild(script);
        },
        loadMap() {
            const container = document.getElementById("map");
            const options = {
                center: new kakao.maps.LatLng(37.498993, 127.032909),
                level: 3
            };

            this.map = new window.kakao.maps.Map(container, options);
            this.loadMarker();
        },
        loadMarker() {
            const markerPosition = new window.kakao.maps.LatLng(37.498993, 127.032909);
            const marker = new window.kakao.maps.Marker({
                position: markerPosition,
            });

            marker.setMap(this.map);
        }
    }

}
</script>

