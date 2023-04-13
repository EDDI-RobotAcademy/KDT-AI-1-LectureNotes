<template>
    <div>
        <h1>Css Test</h1>
        <h2>Web Doc</h2>
        <p>Content: HTML, Design: CSS, Data Handle: JavaScript(TypeScript)</p>
        <section>
            <h2>Who am I ?</h2>
            <p>Interest at MSA</p>
        </section>
    </div>
</template>


<script>

export default {
    
}
</script>

<!-- scoped 이 페이지에서만 적용 (분리 작업 가능)-->
<style scoped>
    h2 {
        font-size: 20px;
        color: orange;
    }
    p {
        color: blue;
    }
    section {
        width: 95%;
        padding: 15px;
        border: 5px solid gray;
    }
</style>