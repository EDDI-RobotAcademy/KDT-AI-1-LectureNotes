import { vuetifyTailwindBoardAppMount } from "../bootstrap"
import router from '../router'

const readBootstrapMount = (el, boardId) => {
  const vueBoardApp = vuetifyTailwindBoardAppMount(el)

  const newRoute = {
    name: 'VuetifyBoardRead',
    params: {
      boardId: boardId,
    }
  }

  router.push(newRoute)
}

export { readBootstrapMount }