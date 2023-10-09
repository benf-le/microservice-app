export const metadata = {
  title: "Add Product",
};

function AddProductPage(props) {
  return (
    <div>
      <h1 className="mb-3 text-lg font-bold">Add Product Page</h1>
      <form>
        <input
          required
          name="name"
          placeholder="Name"
          className="input input-bordered mb-3 w-full"
        />

        <textarea
          required
          name="description"
          placeholder="Description"
          className="textarea textarea-bordered mb-3 w-full"
        />

        <input
          required
          name="imageUrl"
          placeholder="Image URL"
          type="url"
          className="input input-bordered mb-3 w-full"
        />

        <input
          required
          name="price"
          placeholder="Price"
          type="number"
          className="input input-bordered mb-3 w-full"
        />

        <button className="btn btn-primary btn-block" type="submit">
          Add Product
        </button>
      </form>
    </div>
  );
}

export default AddProductPage;
