import { vuetifyTailwindBoardAppMount } from "../bootstrap"
import router from '../router'

const readBootstrapMount = (el) => {
  const vueBoardApp = vuetifyTailwindBoardAppMount(el)

  const newRoute = {
    name: 'VuetifyBoardRead',
  }

  router.push(newRoute)
}

export { readBootstrapMount }