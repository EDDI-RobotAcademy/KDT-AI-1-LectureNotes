import { mount } from "../../../bootstrap"
import router from '../../../router'

const listBootstrapMount = (el, boardId) => {
  const vueBoardApp = mount(el)

  const newRoute = {
    name: 'BoardListPage',
    params: {
      boardId: boardId,
    }
  }

  router.push(newRoute)
}

export { listBootstrapMount }