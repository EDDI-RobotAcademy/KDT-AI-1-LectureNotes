<template>
    <div id="contanier">
        <form>
            <fieldset>
                <legend>사용자 정보</legend>
                <ul style="text-align: left;">
                    <li>
                        <label for="user_id">아이디</label>
                        <input type="text" id="user_id" autofocus placeholder="4~10자 공백없이" required>
                    </li>
                    <li>
                        <label for="user_email">이메일</label>
                        <input type="email" id="user_email" required>
                    </li>
                    <li>
                        <label for="user_password">비밀번호</label>
                        <input type="password" id="user_password" required>
                    </li>
                    <li>
                        <label for="user_password2">비밀번호 확인</label>
                        <input type="password" id="user_password2" required>
                    </li>
                    <li>
                        <label for="path">가입 경로</label>
                        <select id="path">
                            <option value="search">검색</option>
                            <option value="blog">블로그</option>
                            <option value="sns">SNS</option>
                            <option value="etc">기타</option>
                        </select>
                    </li>
                    <li>
                        <label for="memo">메모</label>
                        <textarea placeholder="메모 내용"></textarea>
                    </li>
                </ul>
            </fieldset>
            <fieldset>
                <legend>이벤트와 새로운 소식</legend>
                <input type="radio" name="mailing" id="mailing_y" value="mailing_yes">
                <label for="mailing_y">메일 수신</label>
                <input type="radio" name="mailing" id="mailing_n" value="mailing_no" checked>
                <label for="mailing_n">메일 수신 안함</label>
            </fieldset>
            <div id="buttons">
                <input type="submit" value="가입">&nbsp;
                <input type="reset" value="취소">
            </div>
        </form>

        <form>
            <fieldset style="text-align: left;">
                <h2>예약 정보</h2>
                <ul>
                    <li>
                        <label for="reserve_name">이 름</label>
                        <input type="text" id="reserve_name" autofocus required>
                    </li>
                    <li>
                        <label for="reserve_number">전 화</label>
                        <input type="tel" id="reserve_number" required>
                    </li>
                    <li>
                        <label for="reserve_email">이메일</label>
                        <input type="email" id="reserve_email" required>
                    </li>
                    <li>
                        <input type="submit" value="예약하기">
                    </li>
                </ul>

            </fieldset>
        </form>
    </div>
</template>
<script>
export default {
    name: "PracticePage"
}
</script>
<style></style>