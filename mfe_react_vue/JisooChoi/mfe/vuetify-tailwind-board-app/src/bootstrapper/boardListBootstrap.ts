import { vuetifyTailwindBoardAppMount } from "../bootstrap"
import router from '../router'

const listBootstrapMount = (el) => {
  const vueBoardApp = vuetifyTailwindBoardAppMount(el)

  const newRoute = {
    name: 'VuetifyBoardList',
  }

  router.push(newRoute)
}

export { listBootstrapMount }