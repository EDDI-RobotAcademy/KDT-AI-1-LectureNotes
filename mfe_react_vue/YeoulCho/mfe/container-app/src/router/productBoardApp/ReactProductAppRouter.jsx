import React, { useEffect } from 'react'
const ReactProductAppRouter = ({ reactProductBoardModuleRef }) => {
    useEffect(() => {
        const loadRemoteComponent = async () => {
          const { mount } = await import('reactProductApp/ReactProduct')
          mount(reactProductBoardModuleRef.current)
        }
    
        loadRemoteComponent()
      }, [reactProductBoardModuleRef])
  return (
    <div>
      <div style={{position:'relative'}}>
        {/* <div ref={reactProductBoardModuleRef}/> */}
      </div>
    </div>
  )
}

export default ReactProductAppRouter