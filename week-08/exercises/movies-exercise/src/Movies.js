export default function Movies({ movie }) {
    if (!movie) {
        return <div>Loading...</div>;
    }
    return (
    <div>
        <div>{movie.title}</div>
        <div>{movie.releaseYear}</div>
    </div>
    );
}