import { useState } from 'react';
import { BrowserRouter as Router, Routes, Route, NavLink } from 'react-router-dom';

import Header from './components/Header';
import Main from './components/Main';
import Form from './components/Form';


function App() {

	const [showForm, setShowForm] = useState(false);

	return (
		<Router>
			<div className='container'>
				<Header />
				<Routes>
					<Route path='/home' element={<Form />} />
					<Route path='/about' element={<About />} />
					<Route path='/contact' element={<Contact />} />
				</Routes>
				
				{showForm === true ? (
				<Form setShowForm={setShowForm} />
			) : (
				<Main setShowForm={setShowForm} />
			)}
			</div>
		</Router>
	);
}

export default App;
