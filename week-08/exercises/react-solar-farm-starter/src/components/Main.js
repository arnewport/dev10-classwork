import Table from './Table';

export default function Main({ setShowForm }) {
    return (
    <div>
        <h1 className='mb-3'>Solar Panels</h1>
        <button className='mb-3 btn btn-primary' onClick={() => setShowForm(true)}>
            Add Solar Panel
        </button>
        <Table />
    </div>
    );
}