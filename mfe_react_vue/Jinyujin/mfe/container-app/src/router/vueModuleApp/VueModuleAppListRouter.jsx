import React, { useEffect, useRef } from 'react'

const VueModuleAppListRouter = () => {
    const vueModulListRef = useRef(null)

    useEffect(() => {
        const loadRemoteComponent = async () => {
            const { listBootstrapMount } = await import('vueModuleApp/boardListBootstrap')
            listBootstrapMount(vueModulListRef.current)
        }

        loadRemoteComponent()
    }, [vueModulListRef])

    return (
        <div>
            <div>
                <div style={{ position: 'relative' }} ref={vueModulListRef} />
            </div>
        </div>
    )
}

export default VueModuleAppListRouter