<template>
<div class="all">
    <ul>
    <li class="cannes">
        <div>
            <button class="but" type="button" @click="btn" >옵션</button>
            <div>
                <a class="img" href="@/assets/downloadImg/FF7.jpg">
                    <div class="mask">
                        
                    </div>
                </a>
                
            </div>
        </div>
    </li>
    <li  class="cannes">
        <div>
            <button class="name" type="button" @click="btn">name</button>
            <div>
                <a class="img" href="@/assets/downloadImg/FF7.jpg">
                    <div class="mask">
                        
                    </div>
                </a>
                
            </div>
        </div>
    </li>
    <li  class="cannes">
        <div>
            <button class="pic" type="button" @click="btn">클릭</button>
            <div>
                <a class="img" href="@/assets/downloadImg/FF7.jpg">
                    <div class="mask">
                        
                    </div>
                </a>
                
            </div>
        </div>
    </li>
    <li  class="cannes">
        <div>
            <th class="hid"> 어렵게 작성하는 문장입니다. </th>
            <div>
                <a class="img" href="@/assets/downloadImg/FF7.jpg">
                    <div class="mask">    
                                   
                    </div>
                </a>                
            </div>
        </div>
    </li>
</ul>
</div>
</template>
<script>
export default {
    data() {
        return {
            imageName: ''
   
        }
    },

        
}
</script>
<style>
.cannes {
    width: 40%;
    margin-right: auto;
    margin-left: auto;
    font-family: sans-serif;
    font-size: 18px;
    line-height: 3.2;
    color: #ffffff
    
}
.but {
    cursor: pointer;
    padding: 0px 18px;
    border-radius: 18px 0px 18px 0px;
    color: #ffffff;
    border: 10;
    background-color: rgb(99, 124, 206);
    box-shadow: 2.5px 2.5px 5px rgba(87, 87, 87, 0.555);
    position: absolute;
    top: 10px;
   left: 10px;
}
.name{
    width: 2.5;
    padding: 15px 20px;
    border:5px;
    border-radius: 100%;
    color: #ffffff;
    background-color: #3a3737;
    box-shadow: 5px 5px 5px #929292 inset,5px 5px 5px #818181;
    /*box-shadow: 5px 5px 10px #747474; */
    border: #fff;
    position: absolute;
    top: 10px;
   right: 10px;

}
.pic{
    padding: 0px 20px;
    color: #000;
    box-shadow: 2.5px 2.5px 5px #5757577a;
    animation-name: move;
    animation-duration:1.5s;
  animation-iteration-count:4;
  animation-direction:alternate;
  animation-fill-mode: forwards;
  position: absolute;
  top: 10px;
   left: 100px;

}
.hid{
    width: 10%;
    padding: 100px 300px;
    border: 5px #000;
    box-shadow: 2.5px 2.5px 5px #5757577a;
    top: 100px;
    left: 10px;
    color: #000;

}
p{
    animation-duration: 3s;
    animation-name: slidein;
    animation-iteration-count:infinite;
}
.skeleton-item::before{

}


/* @-webkit-keyframes move {
    0%{
        left: 100px;
    }
    100%{
        left:300px;
    }
} */
@keyframes move {
    0% {
    transform: translateX(0);
  }
  50%,
  100% {
    transform: translateX(460px);
  }
}


</style>