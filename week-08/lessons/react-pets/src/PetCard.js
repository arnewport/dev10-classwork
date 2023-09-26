export default function PetCard({ pet }) {
    // Destructure pets out of props object
    return (
        <div>
            <div>
                <img src={pet.imageUrl} alt={`${pet.name}, a ${pet.breed}`} />
            </div>
            <div>
                <h2>Name: {pet.name}</h2>
                <h3>Breed: {pet.breed}</h3> <ul>
                    <li>DOB: {pet.dob ?? 'Unknown'}</li>
                    <li>Vaccinations: {pet.vaccinationStatus}</li>
                    <li>Adopted: {pet.adopted ? 'Yes' : 'Not yet'}</li>
                </ul>
            </div>
            <div>
                <a href='/'>Edit</a>
                <a href='/'>Delete</a>
            </div>
        </div>
    );
}


