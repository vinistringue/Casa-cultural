// Função para adicionar um filme ao selecionar o botão "Adicionar Filme"
function adicionarFilme() {
    const titulo = document.getElementById("titulo").value;
    const sinopse = document.getElementById("sinopse").value;
    const genero = document.getElementById("genero").value;
    const anoLancamento = document.getElementById("anoLancamento").value;

    // Validação dos campos
    if (!titulo || !sinopse || !genero || !anoLancamento) {
        alert("Por favor, preencha todos os campos.");
        return;
    }

    // Crie um novo elemento HTML com os dados do filme
    const novoFilme = document.createElement("div");
    novoFilme.innerHTML = `
        <h3>${titulo}</h3>
        <p><strong>Gênero:</strong> ${genero}</p>
        <p><strong>Ano de Lançamento:</strong> ${anoLancamento}</p>
        <p><strong>Sinopse:</strong> ${sinopse}</p>
    `;

    // Adicione-o à lista de filmes
    const listaFilmes = document.getElementById("lista-filmes");
    listaFilmes.appendChild(novoFilme);

    // Crie uma nova opção para o filme adicionado
    const novaOpcao = document.createElement("option");
    novaOpcao.text = titulo;
    novaOpcao.value = titulo;

    // Adicione a nova opção à lista de seleção de filmes
    const listaSelecaoFilmes = document.getElementById("filme");
    listaSelecaoFilmes.add(novaOpcao);

    // Limpe os campos do formulário
    document.getElementById("titulo").value = "";
    document.getElementById("sinopse").value = "";
    document.getElementById("genero").value = "";
    document.getElementById("anoLancamento").value = "";

    // Exiba uma mensagem de sucesso
    alert("Filme adicionado com sucesso!");
}

// Função para adicionar uma análise ao selecionar o botão "Adicionar Análise"
function adicionarAnalise() {
    const filmeSelecionado = document.getElementById("filme").value;
    const analise = document.getElementById("analise").value;
    const nota = document.getElementById("nota").value;

    // Validação dos campos
    if (!filmeSelecionado || !analise || !nota) {
        alert("Por favor, preencha todos os campos.");
        return;
    }

    // Crie um novo elemento HTML com os dados da análise
    const novaAnalise = document.createElement("div");
    novaAnalise.innerHTML = `
        <h4>Análise para o filme: ${filmeSelecionado}</h4>
        <p><strong>Nota:</strong> ${nota}</p>
        <p><strong>Comentário:</strong> ${analise}</p>
    `;

    // Adicione-o à exibição de análises (onde você deseja exibi-lo na página)
    const exibicaoAnalises = document.getElementById("exibicao-analises");
    exibicaoAnalises.appendChild(novaAnalise);

    // Limpe os campos do formulário
    document.getElementById("filme").value = "";
    document.getElementById("analise").value = "";
    document.getElementById("nota").value = "";

    // Exiba uma mensagem de sucesso
    alert("Análise adicionada com sucesso!");
}

// Adicione event listeners para os botões "Adicionar Filme" e "Adicionar Análise"
document.getElementById("adicionar-filme-form").addEventListener("submit", function (event) {
    event.preventDefault(); // Evita o envio padrão do formulário
    adicionarFilme();
});

document.getElementById("analise-form").addEventListener("submit", function (event) {
    event.preventDefault(); // Evita o envio padrão do formulário
    adicionarAnalise();
});
