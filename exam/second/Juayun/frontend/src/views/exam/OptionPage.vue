<template lang="">
    <!--3. vue에서 select option을 사용해서 A, B 두 개의 옵션을 넣고 옵션을
         선택하면 옵션 정보를 출력하도록 만들어봅시다-->
    <form style="text-align: center;">
            <fieldset>
                <legend>옵션 선택</legend>
                <ul>
                    <li>
                        <label for="subject">옵션: </label>
                        <select size="5" id="subject" multiple>
                            <option value="A">A</option>
                            <option value="B">B</option>
                        </select>
                    </li>
                </ul>
            </fieldset>
        </form>
</template>

<script>

export default {

}
</script>

<style scoped>
    ul li {
            list-style: none;
            margin: 15px 0;
            font-size: 16px;
        }
    
</style>