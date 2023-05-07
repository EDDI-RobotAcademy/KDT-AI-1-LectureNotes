<template lang="">
    <div>
        <p>
            Problem6Page
            <!--
                페이지 들어가는 버튼을 누르면 = mounted
                페이지로 이동하면서 Spring 서버에 이미지 경로를 요청합니다. = axios 통신
                혹은 사진 이름을 요청해서 이것을 받아옵니다. = string
                (Spring에서 리턴하는 값은 현재 고정하도록 합니다)
                리턴한 값을 받아와서 이 정보를 바탕으로 화면에 사진을 띄워봅시다.
            -->
        </p>        
        <request-image-form/>
    </div>
</template>

<script>
import RequestImageForm from '@/components/homework/problem6/RequestImageForm.vue';

export default {
    components: {
        RequestImageForm
    },

}
</script>

<style lang="">
    
</style>