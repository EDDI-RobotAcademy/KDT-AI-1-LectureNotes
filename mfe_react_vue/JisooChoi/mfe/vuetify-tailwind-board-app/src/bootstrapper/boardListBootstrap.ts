import { vuetifyTailwindBoardAppMount } from "../bootstrap"
import router from '../router'

const listBootstrapMount = (el, boardId) => {
  const vueBoardApp = vuetifyTailwindBoardAppMount(el)

  const newRoute = {
    name: 'VuetifyBoardList',
    params: {
      boardId: boardId,
    }
  }

  router.push(newRoute)
}

export { listBootstrapMount }