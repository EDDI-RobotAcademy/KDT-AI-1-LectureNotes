<template lang="">
    <div>
        <form @submit.prevent="onSubmit">
            <table>
                <tr>
                    <td>이름</td>
                    <td>
                        <input type="text" placeholder="이름을 넣어주세요" v-model="name"/>
                    </td>
                </tr>
                <tr>
                    <td>이메일</td>
                    <td>
                        <input type="text" v-model="email"/>
                    </td>
                </tr>
                <tr>
                    <td>패스워드</td>
                    <td>
                        <input type="password" v-model="password"/>
                    </td>
                </tr>
                <tr>
                    <td>가입종류</td>
                    <td>
                        <div>
                            <input type="radio" @change="check1" v-model="roleType" value="NORMAL">
                            <label>일반회원</label>
                            <!-- <div v-if="normal">
                                <label>사업자 번호</label>
                                <input type="number" v-model="businessNumber"></input>
                            </div> -->
                        </div>  
                        <div>
                            <input type="radio"  @change="check2" v-model="roleType" value="BUSINESS"/>
                            <label>사업자</label>
                            <div v-if="business">
                                <label>사업자 번호</label>
                                <input type="number" v-model="businessNumber"></input>
                            </div>
                        </div>
                    </td>
                </tr>
            </table>

            <div>
                <button type="submit">등록</button> /
                <router-link :to="{ name: 'home' }">
                    취소
                </router-link>
            </div>
        </form>
    </div>
</template>

<script>
export default {
    name: "Test14RegisterMemberForm",
    data () {
        return {
            name: '',
            email: '',
            password: '',
            roleType: '',
            businessNumber: '0',
            normal: true,
            business: false,
        }
    },
    methods: {
        onSubmit () {
            const { name,email,password,roleType,businessNumber } = this
            console.log({ name,email,password,roleType,businessNumber })
            this.$emit('submit', { name,email,password,roleType,businessNumber})
        },
        check1(){
            this.business = false
        },
        check2(){
            this.business = true
        }
    }
}
</script>

<style lang="">
    
</style>