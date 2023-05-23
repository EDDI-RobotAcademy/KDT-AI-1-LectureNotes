<template lang="">
    <v-container>
        <v-data-table :headers="headerTitle" :items="contents" :items-per-page="5" class="elevation-1"/>
    </v-container>
</template>
<script>
export default {
    data() {
        return {//:headers에 매핑 되는 headerTitle 입니다.
            headerTitle: [
                { text: '번호', value: 'boardId', width: "70px" },
                { text: '제목', value: 'title', width: "200px" },
                { text: '작성자', value: 'writer', width: "100px" },
            ],// itmes에 매핑 되는 contents입니다.
            contents:[
                {boardId: 1 ,title: '가위',writer:'종이' },
                {boardId: 2,title: '나비',writer: '곤충'},
                {boardId: 3,title: '다리미',writer: '셔츠'},
                {boardId: 4,title: '라면',writer: '너구리'},
                {boardId: 5,title: '마라',writer: '도삭면'},
                {boardId: 6,title: '바이퍼',writer: '케리아'},
                {boardId: 7,title: '사자',writer: '백수'},
                {boardId: 8,title: '아리',writer:'리산드라' },
                {boardId: 9,title: '자카르타',writer: '팔렘방'},
                {boardId: 10,title: '차범근',writer: '붐'},
                { boardId: 11, title: '헬로!', writer: '헬로' },
                { boardId: 12, title: '곰방와!', writer: '곰방와' },

            ]
        }
    },
    
}
</script>
<style lang="">
    
</style>