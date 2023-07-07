import { vuetifyTailwindBoardAppMount } from "../bootstrap"
import router from '../router'

const modifyBootstrapMount = (el, boardId) => {
  const vueBoardApp = vuetifyTailwindBoardAppMount(el)

  const newRoute = {
    name: 'VuetifyBoardModify',
    params: {
      boardId: boardId,
    }
  }

  router.push(newRoute)
}

export { modifyBootstrapMount }