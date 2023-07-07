import { vuetifyTailwindBoardAppMount } from "../bootstrap"
import router from "../router"

const modifyBootstrapMount = (el, boardId) => {
    // 게시물 번호 받아주도록 해야함
    const vueBoardApp = vuetifyTailwindBoardAppMount(el)

    const newRoute = {
        name: 'VuetifyBoardModify',
        params: {
            boardId: boardId
        }
    }

    router.push(newRoute)
}

export { modifyBootstrapMount }