const solarPanels = [
	{
		id: 17,
		section: 'The Ridge',
		row: 1,
		column: 1,
		yearInstalled: 2020,
		material: 'POLY_SI',
		tracking: true,
	},
	{
		id: 18,
		section: 'The Ridge',
		row: 1,
		column: 2,
		yearInstalled: 2021,
		material: 'CIGS',
		tracking: true,
	},
	{
		id: 19,
		section: 'Flats',
		row: 1,
		column: 1,
		yearInstalled: 2020,
		material: 'CD_TE',
		tracking: false,
	},
];

export default function Table() {
    return (
        <table className='table table-striped'>
            <thead>
                <tr>
                    <th>Section</th>
                    <th>Row</th>
                    <th>Column</th>
                    <th>Year Installed</th>
                    <th>Material</th>
                    <th>Tracking Software</th>
                    <th>Modify</th>
                </tr>
            </thead>
            <tbody>
                {solarPanels.map(solarPanel => (
                    <tr>
                        <td>{solarPanel.section}</td>
                        <td>{solarPanel.row}</td>
                        <td>{solarPanel.column}</td>
                        <td>{solarPanel.yearInstalled}</td>
                        <td>{solarPanel.material}</td>
                        <td>{solarPanel.tracking ? 'Yes' : 'No'}</td>
                        <td>
                            <button className='btn btn-warning me-2 mb-2'>
                                Edit
                            </button>
                            <button className='btn btn-danger'>
                                Delete
                            </button>
                        </td>
                    </tr>
                ))}
            </tbody>
        </table>
    );
}