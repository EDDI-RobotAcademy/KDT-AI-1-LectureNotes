<template lang="">
    <div>
        <table>
            <tr>
                <td>상품 번호</td>
                <td>
                    <input type="text" :value="board.boardId" readonly/>
                </td>
            </tr>
            <tr>
                <td>상품명</td>
                <td>
                    <input type="text" :value="board.title" readonly/>
                </td>
            </tr>
            <tr>
                <td>상품 가격</td>
                <td>
                    <input type="text" :value="board.writer" readonly/>
                </td>
            </tr>
        </table>
    </div>
</template>

<script>
export default {
    name: "ProductReadForm",
    props: {
        board: {
            type: Object,
            required: true,
        }
    }
}
</script>

<style lang="">
    
</style>