import './App.css'
import Header from './components/Header/Header'
import Navi from './components/Navi/Navi'
import Footer from './components/Footer/Footer'
import Body from './components/Body/Body'
function App() {
  // JSX의 결과로 반환시킬 수 있는 결과 값은 최상위 컴포넌트 하나만 가능함.
  // 하나 이상의 컴포넌트를 반환시켜야 할 경우 Fragment를 통해 가상의 최상위 컴포넌트로 묶어주는 기법 사용 가능. <></>

  // Local Scoping : 특정 파일 내에서만 사용할 수있는 이름으로 자동 생성되는 기술

  return (
    <div className="container">
      <Header />
      <Navi />
      <Body />
      <Footer />
    </div>
  )
}

export default App
