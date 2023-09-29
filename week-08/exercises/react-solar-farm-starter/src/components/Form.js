import { useState } from 'react';

function Form({ setShowForm }) {
  const [formData, setFormData] = useState({
    section: '',
    row: '',
    column: '',
    yearInstalled: '',
    material: [],
    isTracking: false,
  });

  const handleInputChange = (event) => {
    const { name, value, type, checked } = event.target;

    if (type === 'checkbox') {
      setFormData({
        ...formData,
        [name]: checked,
      });
    } else if (type === 'select-multiple') {
      const options = event.target.options;
      const selectedOptions = [];
      for (let i = 0; i < options.length; i++) {
        if (options[i].selected) {
          selectedOptions.push(options[i].value);
        }
      }
      setFormData({
        ...formData,
        [name]: selectedOptions,
      });
    } else {
      setFormData({
        ...formData,
        [name]: value,
      });
    }
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    // Here, you can submit the formData to your backend or perform any other actions.
    console.log(formData);
  };

  return (
    <div className="container">
      <h2 className="mt-4">Solar Panel Form</h2>
      <form onSubmit={handleSubmit} className="mt-3">
        <div className="mb-3">
          <label className="form-label">Section:</label>
          <input
            type="text"
            name="section"
            value={formData.section}
            onChange={handleInputChange}
            className="form-control"
          />
        </div>
        <div className="mb-3">
          <label className="form-label">Row:</label>
          <input
            type="text"
            name="row"
            value={formData.row}
            onChange={handleInputChange}
            className="form-control"
          />
        </div>
        <div className="mb-3">
          <label className="form-label">Column:</label>
          <input
            type="text"
            name="column"
            value={formData.column}
            onChange={handleInputChange}
            className="form-control"
          />
        </div>
        <div className="mb-3">
          <label className="form-label">Year Installed:</label>
          <input
            type="text"
            name="yearInstalled"
            value={formData.yearInstalled}
            onChange={handleInputChange}
            className="form-control"
          />
        </div>
        <div className="mb-3">
          <label className="form-label">Material:</label>
          <select
            name="material"
            multiple
            value={formData.material}
            onChange={handleInputChange}
            className="form-select"
          >
            <option value="polycrystalline">Polycrystalline</option>
            <option value="monocrystalline">Monocrystalline</option>
            <option value="thin-film">Thin Film</option>
          </select>
        </div>
        <div className="mb-3">
          <div className="form-check">
            <input
              type="checkbox"
              name="isTracking"
              checked={formData.isTracking}
              onChange={handleInputChange}
              className="form-check-input"
            />
            <label className="form-check-label">Is Tracking</label>
          </div>
        </div>
        <div className="mb-3">
            <button type="submit" className="btn btn-primary">Submit</button>
            <button type='btn' className='btn btn-secondary' onClick={() => setShowForm(false)}>
                Cancel
            </button>
        </div>
      </form>
    </div>
  );
}

export default Form;
