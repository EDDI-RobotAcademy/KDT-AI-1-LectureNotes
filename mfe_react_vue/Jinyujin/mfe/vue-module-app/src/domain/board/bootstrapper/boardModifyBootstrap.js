import {mount} from "../../../bootstrap"
import router from "../../../router"

const modifyBootstrapMount = (el, boardId) => {
    // 게시물 번호 받아주도록 해야함
    const vueBoardApp = mount(el)

    const newRoute = {
        name: 'BoardModifyPage',
        params: {
            boardId: boardId
        }
    }

    router.push(newRoute)
}

export { modifyBootstrapMount }