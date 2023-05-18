<template lang="">
    <nav>
       <input type="checkbox" id="menuicon">
       <label for="menuicon">
            <span></span>
            <span></span>
        </label>
        <div class="sidebar">
        </div>
    </nav>
</template>
<script>
export default {
    
}
</script>
<style lang="">
    div[class="sidebar"]{
        width: 300px;
        height: 100%;
        background: #222;
        position: fixed;
        top: 0;
        left:-300px;
        z-index:1;
        transition: all .35s;
    }
    input[id="menuicon"]:checked + label +div {
        left: 0;
    }
</style>