import { vuetifyTailwindBoardAppMount } from "../bootstrap"
import router from "../router"

const readBootstrapMount = (el, boardId) => {
    // 게시물 번호 받아주도록 해야함
    const vueBoardApp = vuetifyTailwindBoardAppMount(el)

    const newRoute = {
        name: 'VuetifyBoardRead',
        params: {
            boardId: boardId
        }
    }

    router.push(newRoute)
}

export { readBootstrapMount }