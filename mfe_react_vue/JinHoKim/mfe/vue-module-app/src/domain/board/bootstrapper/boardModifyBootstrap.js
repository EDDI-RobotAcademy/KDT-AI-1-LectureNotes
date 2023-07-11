import { mount } from "../../../bootstrap"
import router from "../../../router"

const modifyBootstrapMount = (el, boardId) => {
  const vueBoardApp = mount(el)

  const newRoute = {
    name: 'BoardModifyPage',
    params: {
      boardId: boardId,
    }
  }

  router.push(newRoute)
}

export { modifyBootstrapMount }
