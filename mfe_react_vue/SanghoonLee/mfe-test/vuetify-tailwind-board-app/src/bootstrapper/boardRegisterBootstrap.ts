import { vuetifyTailwindBoardAppMount } from "../bootstrap"
import router from '../router'

const registerBootstrapMount = (el) => {
  const vueBoardApp = vuetifyTailwindBoardAppMount(el)

  const newRoute = {
    name: 'VuetifyBoardRegister',
  }

  router.push(newRoute)
}

export { registerBootstrapMount }