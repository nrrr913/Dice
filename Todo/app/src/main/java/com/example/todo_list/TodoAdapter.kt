package com.example.todo_list

data class Todo(
    val text: String,
    var isDone: Boolean = false,
)

class TodoAdapter(
    private val dataSet: List<Todo>,
//추가시작
    val onClickDeleteIcon: (todo: Todo) -> Unit //2. delete button이 눌렸을때 onclickDeleteIcon을 실행하라는뜻, 0->Unit이기때문에 함수자체에 return없다는뜻
//추가 끝
) :
    RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    class TodoViewHolder(val binding: ItemTodoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val todoText: TextView
            get() {
                TODO()
            }

    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_todo, viewGroup, false)

        return TodoViewHolder(ItemTodoBinding.bind(view))
    }

    override fun onBindViewHolder(todoViewHolder: TodoViewHolder, position: Int) {//item을 화면에 표시해주는
        val listposition = dataSet[position]
        todoViewHolder.binding.todoText.text = listposition.text
//추가시작
        todoViewHolder.binding.deleteImage.setOnClickListener {
            onClickDeleteIcon.invoke(listposition) //1. deleteimage가 눌렸을때 listposition를 전달하면서 onClickDeleteIcon함수를 실행한다.
        }
//추가끝

    }

    override fun getItemCount() = dataSet.size

}